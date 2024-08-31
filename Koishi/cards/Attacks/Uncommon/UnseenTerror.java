/*    */ package Koishi.cards.Attacks.Uncommon;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.EphemeralPower;
/*    */ import Koishi.powers.TerrorPower;
/*    */ import basemod.abstracts.CustomCard;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.actions.common.DamageAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class UnseenTerror extends AbstractDefaultCard {
/* 20 */   public static final String ID = KoishiMod.makeID(UnseenTerror.class.getSimpleName());
/* 21 */   public static final String IMG = KoishiMod.makeCardPath("UnseenTerror.png");
/*    */   
/* 23 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 24 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 25 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 26 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 2;
/*    */   
/*    */   private static final int DAMAGE = 15;
/*    */   
/*    */   private static final int UPGRADE_PLUS_DMG = 3;
/*    */   
/*    */   private static final int DEBUFF = 2;
/*    */   private static final int UPGRADE_PLUS_DEBUFF = 1;
/*    */   private static final int BUFF = 2;
/*    */   
/*    */   public UnseenTerror() {
/* 39 */     super(ID, IMG, 2, TYPE, COLOR, RARITY, TARGET);
/* 40 */     this.baseDamage = 15;
/* 41 */     this.magicNumber = this.baseMagicNumber = 2;
/* 42 */     this.defaultSecondMagicNumber = this.defaultBaseSecondMagicNumber = 2;
/* 43 */     KoishiMod.setBackground((CustomCard)this, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 48 */     KoishiMod.runAnimation("dashAttackB");
/* 49 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.BLUNT_HEAVY));
/*    */     
/* 51 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new EphemeralPower((AbstractCreature)p, this.defaultSecondMagicNumber), this.defaultSecondMagicNumber));
/* 52 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new TerrorPower((AbstractCreature)m, (AbstractCreature)p, this.magicNumber), this.magicNumber));
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 57 */     if (!this.upgraded) {
/* 58 */       upgradeName();
/* 59 */       upgradeDamage(3);
/* 60 */       upgradeMagicNumber(1);
/* 61 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Uncommon/UnseenTerror.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */