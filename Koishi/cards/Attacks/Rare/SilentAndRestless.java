/*    */ package Koishi.cards.Attacks.Rare;
/*    */ import Koishi.KoishiMod;
/*    */ import Koishi.actions.SilentAndRestlessAction;
/*    */ import Koishi.cards.AbstractDefaultCard;
/*    */ import Koishi.characters.KoishiCharacter;
/*    */ import Koishi.powers.EphemeralPower;
/*    */ import com.evacipated.cardcrawl.mod.stslib.fields.cards.AbstractCard.AlwaysRetainField;
/*    */ import com.megacrit.cardcrawl.actions.AbstractGameAction;
/*    */ import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
/*    */ import com.megacrit.cardcrawl.cards.AbstractCard;
/*    */ import com.megacrit.cardcrawl.cards.DamageInfo;
/*    */ import com.megacrit.cardcrawl.characters.AbstractPlayer;
/*    */ import com.megacrit.cardcrawl.core.AbstractCreature;
/*    */ import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
/*    */ import com.megacrit.cardcrawl.monsters.AbstractMonster;
/*    */ import com.megacrit.cardcrawl.powers.AbstractPower;
/*    */ 
/*    */ public class SilentAndRestless extends AbstractDefaultCard {
/* 19 */   public static final String ID = KoishiMod.makeID(SilentAndRestless.class.getSimpleName());
/* 20 */   public static final String IMG = KoishiMod.makeCardPath("SilentAndRestless.png");
/*    */   
/* 22 */   private static final AbstractCard.CardRarity RARITY = AbstractCard.CardRarity.RARE;
/* 23 */   private static final AbstractCard.CardTarget TARGET = AbstractCard.CardTarget.ENEMY;
/* 24 */   private static final AbstractCard.CardType TYPE = AbstractCard.CardType.ATTACK;
/* 25 */   public static final AbstractCard.CardColor COLOR = KoishiCharacter.Enums.COLOR_DARK_GREEN;
/*    */   
/*    */   private static final int COST = 1;
/*    */   
/*    */   private static final int DAMAGE = 13;
/*    */   
/*    */   private static final int UPGRADE_PLUS_DAMAGE = 5;
/*    */   
/*    */   private static final int BUFF = 2;
/*    */   private static final int KILL_BONUS = 2;
/*    */   
/*    */   public SilentAndRestless() {
/* 37 */     super(ID, IMG, 1, TYPE, COLOR, RARITY, TARGET);
/* 38 */     this.baseDamage = 13;
/* 39 */     this.misc = 2;
/* 40 */     this.magicNumber = this.baseMagicNumber = this.misc;
/* 41 */     this.defaultSecondMagicNumber = this.defaultBaseSecondMagicNumber = 2;
/* 42 */     this.exhaust = true;
/* 43 */     AlwaysRetainField.alwaysRetain.set(this, Boolean.valueOf(true));
/*    */   }
/*    */ 
/*    */   
/*    */   public void use(AbstractPlayer p, AbstractMonster m) {
/* 48 */     KoishiMod.runAnimation("dashAttackA");
/* 49 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new SilentAndRestlessAction((AbstractCreature)m, new DamageInfo((AbstractCreature)p, this.damage, this.damageTypeForTurn), this.defaultSecondMagicNumber, this.uuid));
/* 50 */     AbstractDungeon.actionManager.addToBottom((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new EphemeralPower((AbstractCreature)p, this.baseMagicNumber), this.baseMagicNumber));
/*    */   }
/*    */ 
/*    */   
/*    */   public void applyPowers() {
/* 55 */     this.magicNumber = this.baseMagicNumber = this.misc;
/* 56 */     super.applyPowers();
/* 57 */     initializeDescription();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public float getTitleFontSize() {
/* 63 */     return 20.0F;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void upgrade() {
/* 69 */     if (!this.upgraded) {
/* 70 */       upgradeName();
/* 71 */       upgradeDamage(5);
/* 72 */       initializeDescription();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              /home/voxelle/Desktop/Koishi.jar!/Koishi/cards/Attacks/Rare/SilentAndRestless.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */