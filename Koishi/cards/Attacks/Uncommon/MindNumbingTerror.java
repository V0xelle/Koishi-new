/*    */ package Koishi.cards.Attacks.Uncommon;
/*    */ 
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.TerrorPower;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ 
/*    */ public class MindNumbingTerror extends AbstractDefaultCard {
/* 18 */   public static final String ID = KoishiMod.makeID(MindNumbingTerror.class.getSimpleName());
/* 19 */   public static final String IMG = KoishiMod.makeCardPath("MindNumbingTerror.png");
/*    */   
/* 21 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 22 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 23 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 24 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int DAMAGE = 10;
/*    */   private static final int UPGRADE_PLUS_DAMAGE = 3;
/*    */   
/*    */   public MindNumbingTerror() {
/* 32 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 33 */     this.baseDamage = 10;
/* 34 */     KoishiMod.setBackground((CustomCard)this, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 39 */     KoishiMod.runAnimation("airAttack");
/* 40 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_HEAVY));
/* 41 */     for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
/* 42 */       if (mo.hasPower(TerrorPower.POWER_ID)) {
/* 43 */         int hpLoss = (mo.getPower(TerrorPower.POWER_ID)).amount;
/* 44 */         AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)mo, new DamageInfo((AbstractCreature)p, hpLoss, DamageInfo.DamageType.HP_LOSS), AbstractGameAction.AttackEffect.NONE));
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 52 */     return 16.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 58 */     if (!this.upgraded) {
/* 59 */       upgradeName();
/* 60 */       upgradeDamage(3);
/* 61 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Uncommon/MindNumbingTerror.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */