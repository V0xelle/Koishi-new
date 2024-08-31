/*    */ package Koishi.cards.Attacks.Uncommon;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
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
/*    */ import com.megacrit.cardcrawl.powers.GainStrengthPower;
/*    */ import com.megacrit.cardcrawl.powers.StrengthPower;
/*    */ 
/*    */ public class TremblingHands extends AbstractDefaultCard {
/* 21 */   public static final String ID = KoishiMod.makeID(TremblingHands.class.getSimpleName());
/* 22 */   public static final String IMG = KoishiMod.makeCardPath("TremblingHands.png");
/*    */   
/* 24 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.UNCOMMON;
/* 25 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 26 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 27 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int DAMAGE = 7;
/*    */   private static final int UPGRADE_PLUS_DMG = 3;
/*    */   
/*    */   public TremblingHands() {
/* 35 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 36 */     this.baseDamage = 7;
/* 37 */     KoishiMod.setBackground((CustomCard)this, 0);
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 42 */     KoishiMod.runAnimation("dashAttackA");
/* 43 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new DamageAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), AbstractGameAction.AttackEffect.SLASH_DIAGONAL));
/*    */     
/* 45 */     if (m.hasPower(TerrorPower.POWER_ID)) {
/* 46 */       int debuffAmount = (m.getPower(TerrorPower.POWER_ID)).amount;
/* 47 */       AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new StrengthPower((AbstractCreature)m, -debuffAmount), -debuffAmount));
/* 48 */       if (m != null && !m.hasPower("Artifact")) {
/* 49 */         AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)m, (AbstractCreature)p, (AbstractPower)new GainStrengthPower((AbstractCreature)m, debuffAmount), debuffAmount));
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 56 */     if (!this.upgraded) {
/* 57 */       upgradeName();
/* 58 */       upgradeDamage(3);
/* 59 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Uncommon/TremblingHands.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */